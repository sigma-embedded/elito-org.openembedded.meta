DESCRIPTION = "LXDM is the lightweight display manager"
HOMEPAGE = "http://blog.lxde.org/?p=531"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SRC_URI = " \
	git://lxde.git.sourceforge.net/gitroot/lxde/${BPN};protocol=git;branch=master \
	file://lxdm.conf \
	file://lxdm-pam \
	file://lxdm-pam-debug \
	${@base_contains("DISTRO_TYPE", "debug", "", "file://0001-lxdm.conf.in-blacklist-root-for-release-images.patch",d)} \
"

LXDM_PAM = "${@base_contains("DISTRO_TYPE", "debug", "lxdm-pam-debug", "lxdm-pam",d)}"

SRCREV = "65e7cc8fdc150c2b925eb348ce82de17dee5eb0b"
PV = "0.4.2+git${SRCPV}"
PE = "1"
PR = "r3"

DEPENDS = "cairo consolekit dbus gdk-pixbuf glib-2.0 gtk+ virtual/libx11 libxcb pango"

# combine oe-core way with angstrom DISTRO_TYPE
DISTRO_TYPE ?= "${@base_contains("IMAGE_FEATURES", "debug-tweaks", "debug", "",d)}"

inherit autotools gettext

S = "${WORKDIR}/git"

SYSTEMD_UNITDIR ??= "no"
EXTRA_OECONF = "--with-systemdsystemunitdir=${SYSTEMD_UNITDIR}"

do_compile_append() {
	# default background configured not available / no password field available / no default screensaver
	sed -i 	-e 's,bg=,# bg=,g' \
		-e 's,# skip_password=,skip_password=,g' \
		-e 's,# arg=.*,arg=${bindir}/X -s 0,g' \
		${S}/data/lxdm.conf.in
	# add default configuration
	oe_runmake -C ${S}/data lxdm.conf
}

do_install_append() {
	install -d ${D}${localstatedir}/lib/lxdm
	install -m 644 ${WORKDIR}/lxdm.conf ${D}${localstatedir}/lib/lxdm
	# ArchLinux version of pam config has the following advantages:
	# * simple setup of passwordless login
	# * in XFCE powerdown/restart enabled in logoff dialog
	install -m 644 ${WORKDIR}/${LXDM_PAM} ${D}${sysconfdir}/pam.d/lxdm
}

# make installed languages choosable
pkg_postinst_${PN} () {
if [ "x$D" != "x" ]; then
    exit 1
fi
langs=""
for lang in `find ${libdir}/locale -maxdepth 1 | grep _ | sort`; do
    lang=`basename $lang`
    if [ "x$langs" = "x" ]; then
        langs="$lang"
    else
        langs="$langs $lang"
    fi
done
sed -i "s:last_langs=.*$:last_langs=$langs:g" ${localstatedir}/lib/lxdm/lxdm.conf
}

RDEPENDS_${PN} = "pam-plugin-loginuid setxkbmap"
