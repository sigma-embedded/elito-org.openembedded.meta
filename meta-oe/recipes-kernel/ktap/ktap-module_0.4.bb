# Released under the MIT license (see COPYING.MIT for the terms)

require ktap.inc

DESCRIPTION = "KTAP is a scripting dynamic tracing tool for Linux"

inherit module

# Only build the module
MAKE_TARGETS = "mod"

# Kernel module packages MUST begin with 'kernel-module-', otherwise
# multilib image generation can fail.
#
# The following line is only necessary if the recipe name does not begin
# with kernel-module-.
#
PKG_${PN} = "kernel-module-${PN}"

