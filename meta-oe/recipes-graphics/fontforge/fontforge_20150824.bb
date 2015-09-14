SUMMARY = "A font editor"
HOMEPAGE = "http://fontforge.github.io/en-US/"
LICENSE = "BSD-3-Clause & GPLv3"
LIC_FILES_CHKSUM = " \
    file://COPYING.gplv3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE;md5=3f922b42ed0033fa0fd4cd3268f6429c \
"

inherit autotools pkgconfig pythonnative distro_features_check

DEPENDS = "glib-2.0 pango giflib tiff libxml2 jpeg python libtool"
DEPENDS_append_class-target = " libxi"
REQUIRED_DISTRO_FEATURES_append_class-target = " x11"

SRC_URI = "git://github.com/${BPN}/${BPN}.git"
# tag 20150824
SRCREV = "07d5ccff2704f8a56f1b3cc6695a4e31f85f88e6"
S = "${WORKDIR}/git"

EXTRA_OECONF_append_class-native = " with_x=no --disable-python-extension --disable-python-scripting"

do_configure_prepend() {
    currdir=`pwd`
    cd ${S}
    ./bootstrap --force
    cd $currdir
}

EXTRA_OEMAKE = "CFLAGS='${CFLAGS} -I${B}/uthash/src'"

PACKAGES =+ "${PN}-python-dbg ${PN}-python"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/icons \
"

FILES_${PN}-python = "${PYTHON_SITEPACKAGES_DIR} ${datadir}/${PN}/python"
FILES_${PN}-python-dbg = "${PYTHON_SITEPACKAGES_DIR}/.debug"
RDEPENDS_${PN}-python = "python"

# for e.g kde's oxygen-fonts
BBCLASSEXTEND = "native"
