SUMMARY = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a916467b91076e631dd8edb7424769c7"

inherit autotools pkgconfig gnomebase distutils-base gobject-introspection

PYTHON_BASEVERSION = "2.7"
PYTHON_PN = "python"

DEPENDS += "python glib-2.0"

SRCNAME="pygobject"
SRC_URI = " \
    http://ftp.gnome.org/pub/GNOME/sources/${SRCNAME}/${@gnome_verdir("${PV}")}/${SRCNAME}-${PV}.tar.xz \
    file://0001-configure.ac-add-sysroot-path-to-GI_DATADIR-don-t-se.patch \
"

SRC_URI[md5sum] = "0a956f3e785e23b0f136832f2e57a862"
SRC_URI[sha256sum] = "2a3cad1517916b74e131e6002c3824361aee0671ffb0d55ded119477fc1c2c5f"

S = "${WORKDIR}/${SRCNAME}-${PV}"

BBCLASSEXTEND = "native"

EXTRA_OECONF = "--disable-cairo --with-python=${PYTHON}"

RDEPENDS_${PN} += "python-setuptools python-importlib"

do_install_append() {
    # Remove files that clash with python3-pygobject; their content is same
    rm ${D}${includedir}/pygobject-3.0/pygobject.h ${D}${libdir}/pkgconfig/pygobject-3.0.pc
}

