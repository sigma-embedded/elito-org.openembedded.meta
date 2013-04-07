FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 2}"

inherit systemd

SRC_URI += "file://entrance.service"

RPROVIDES_${PN} += "${PN}"

SYSTEMD_SERVICE_${PN} = "entrance.service"

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/entrance.service ${D}${systemd_unitdir}/system
}

RCONFLICTS_${PN} += "xserver-nodm-init-systemd"
RREPLACES_${PN} += "xserver-nodm-init-systemd"
