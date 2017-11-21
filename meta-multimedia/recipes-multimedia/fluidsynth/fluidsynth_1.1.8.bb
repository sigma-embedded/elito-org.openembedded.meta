SUMMARY = "Fluidsynth is a software synthesizer"
HOMEPAGE = "http://www.fluidsynth.org/"
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

DEPENDS = "alsa-lib ncurses glib-2.0"

SRC_URI = "git://github.com/FluidSynth/fluidsynth.git;branch=1.1.x"
SRCREV = "12e7afe3a806a6b397f28e0ca4bc6bab9ebe7047"
S = "${WORKDIR}/git"

inherit cmake pkgconfig lib_package

EXTRA_OECMAKE = "-DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')}"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[sndfile] = "-Denable-libsndfile-support=ON,-Denable-libsndfile-support=OFF,libsndfile1"
PACKAGECONFIG[jack] = "-Denable-jack-support=ON,-Denable-jack-support=OFF,jack"
PACKAGECONFIG[pulseaudio] = "-Denable-pulseaudio=ON,--Denable-pulseaudio=OFF,pulseaudio"
PACKAGECONFIG[portaudio] = "-Denable-portaudio=ON,-Denable-portaudio=OFF,portaudio-v19"
