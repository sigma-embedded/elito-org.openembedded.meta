PACKAGES =+ "kexec kdump"

FILES_kexec = "${sbindir}/kexec"
FILES_kdump = "${sbindir}/kdump"

RDEPENDS_${PN} += "kexec kdump"
ALLOW_EMPTY_${PN} = "1"
