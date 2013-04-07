FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 1}"

inherit systemd

SRC_URI += "file://cherokee.service"

SYSTEMD_PACKAGES = "${PN}"
RPROVIDES_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "cherokee.service"

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/cherokee.service ${D}${systemd_unitdir}/system
}
