inherit systemd

PRINC := "${@int(PRINC) + 1}"

SYSTEMD_UNITDIR = "${systemd_unitdir}/system"
EXTRA_OECONF += "--enable-socket-activation --with-systemdsystemunitdir=${SYSTEMD_UNITDIR}"
SYSTEMD_PACKAGES = "${PN}-uuidd"
RPROVIDES_${PN}-uuid += "${PN}-systemd"
SYSTEMD_SERVICE_${PN}-uuid = "uuidd.socket"
