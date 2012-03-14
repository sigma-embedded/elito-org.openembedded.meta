DESCRIPTION = "Meet Cloud9, development-as-a-service for Javascripters and other developers"
HOMEPAGE = "http://c9.io"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4784c3bcff601fd8f9515f52a11e7018"

DEPENDS = "libxml2 nodejs-native"

PR = "r15"

SRC_URI = "git://github.com/ajaxorg/cloud9.git;name=cloud9ide \
           git://github.com/ajaxorg/o3;destsuffix=o3;name=o3 \
           git://github.com/ajaxorg/ace.git;destsuffix=git/support/ace;name=ace \
           git://github.com/ajaxorg/ace.wiki.git;destsuffix=git/support/ace/doc/wiki;name=acewiki \
           git://github.com/ajaxorg/cockpit.git;destsuffix=git/support/ace/support/cockpit;name=cockpit \
           git://github.com/ajaxorg/dryice.git;destsuffix=git/support/ace/support/dryice;name=dryice \
           git://github.com/ajaxorg/pilot.git;destsuffix=git/support/ace/support/pilot;name=pilot \
           git://github.com/ajaxorg/apf.git;destsuffix=git/support/apf;name=apf \
           git://github.com/ajaxorg/async.js.git;destsuffix=git/support/asyncjs;name=asyncjs \
           git://github.com/ajaxorg/connect.git;destsuffix=git/support/connect;name=connect \
           git://github.com/jashkenas/coffee-script.git;destsuffix=git/support/connect/support/coffee-script;name=coffee-script \
           git://github.com/visionmedia/expresso.git;destsuffix=git/support/connect/support/expresso;name=expresso \
           git://github.com/visionmedia/node-jscoverage.git;destsuffix=git/support/connect/support/expresso/deps/jscoverage;name=jscoverage \
           git://github.com/cloudhead/less.js.git;destsuffix=git/support/connect/support/less;name=less \
           git://github.com/visionmedia/sass.js.git;destsuffix=git/support/connect/support/sass;name=sass \
           git://github.com/ajaxorg/jsDAV.git;destsuffix=git/support/jsdav;name=jsdav \
           git://github.com/fjakobs/async.js.git;destsuffix=git/support/jsdav/support/async.js;name=async-js \
           git://github.com/felixge/node-formidable.git;destsuffix=git/support/jsdav/support/formidable;name=formidable \
           git://github.com/ajaxorg/jsftp.git;destsuffix=git/support/jsdav/support/jsftp;name=jsftp \
           git://github.com/Gozala/streamer.git;destsuffix=git/support/jsdav/support/jsftp/support/streamer;name=streamer \
           git://github.com/ajaxorg/node-sftp.git;destsuffix=git/support/jsdav/support/node-sftp;name=sftp \
           git://github.com/ajaxorg/lib-v8debug.git;destsuffix=git/support/lib-v8debug;name=lib-v8debug \
           git://github.com/ajaxorg/socket.io.git;destsuffix=git/support/socket.io;name=socketio \
           git://github.com/LearnBoost/socket.io-client.git;destsuffix=git/support/socket.io-client;name=socketio-client \
           git://github.com/ajaxorg/UglifyJS.git;destsuffix=git/support/uglify-js;name=uglify-js \
           file://index.js \
           file://cloud9.service \
           file://cloud9-avahi.service \
          "

SRCREV_cloud9ide = "e61d37c19b981e8750084a1c3df60365f3436c19"
SRCREV_o3 = "49ccc189a12728475875e9e7a9040553ab0b2316"
SRCREV_ace = "9ec72ff319c06c4a1f93dae3157021eefbac338d"
SRCREV_acewiki = "cc5ccde4565f7b21c81345f47e941e011e94b810"
SRCREV_cockpit = "33f02ab3af5d755c98b3c58309ac2c62fc6de736"
SRCREV_dryice = "375d9a339646d70846ad40eddaad406198dd9d40"
SRCREV_pilot = "48ddaa841476ddf9210ccbb2b310952db8212084"
SRCREV_apf = "d8d24b52829803d7e55fec90607a2595975402b8"
SRCREV_asyncjs = "d36ead408e2959b1e99572114ef3a1b6a48c1072"
SRCREV_connect = "6bec95b51f2286b942bc7f340d62d816bcdc13d4"
SRCREV_coffee-script = "a53c104db16d3ac9d13cf9f16834edec250b9749"
SRCREV_expresso = "7f10ab7fa655299b4e2f519065b0495e6ac34ef2"
SRCREV_jscoverage = "0d4608a6b4275b020ba665389aa75897d5d4a584"
SRCREV_less = "a2807288008587b95c6c2f8ba5cac16f1bcab98f"
SRCREV_sass = "4dfd4c699e7a8baf226215ab044854c4507f4420"
SRCREV_jsdav = "b06a73920ebdb1a671e86e2e47ee67400ba14785"
SRCREV_async-js = "92fb710a70efd3cdc2376ebfba71a7fb3a4f1651"
SRCREV_formidable = "0cba820cabc23250d47754e57d9f61cc73d12f2a"
SRCREV_jsftp = "f93b4eeb6d96ffebbc378c8c040684cf82a63885"
SRCREV_streamer = "1a7f75d4065819171ac91a09974199b932dbe17d"
SRCREV_sftp = "a0539345134970d7535a19cb2608e3d1bc119d71"
SRCREV_lib-v8debug = "29b20d01e6854da2173e1665ea141dab6b5a8104"
SRCREV_socketio = "735d5239b325df2ba67d2b9bb4ec32442283bc06"
SRCREV_socketio-client = "d12e0714e96490dfff770dc1d184e672549c6477"
SRCREV_uglify-js = "941c845c4a01e4e47a158458fe846eb36d0828ad"

SRCREV_FORMAT = "cloud9ide"

S = "${WORKDIR}/git"

do_configure () {
 cd ${WORKDIR}/o3
 node-waf -vv configure
}

EXTRA_CXXFLAGS = "-Idefault/include -I../include -Idefault/hosts -I../hosts -Idefault/modules -I../modules -Idefault/deps -I../deps -I${STAGING_DIR_NATIVE}/usr/include/node -fPIC -DPIC"

do_compile () {
 cd ${WORKDIR}/o3
 node tools/gluegen.js
 cd hosts
 ${CXX} ${TARGET_CXXFLAGS} ${EXTRA_CXXFLAGS} -c -o sh_node.o node-o3/sh_node.cc
 ${CXX} ${TARGET_CXXFLAGS} ${EXTRA_CXXFLAGS} -c -o sh_node_libs.o node-o3/sh_node_libs.cc
 cd ..
 ${CXX} ${TARGET_LDFLAGS} hosts/sh_node.o hosts/sh_node_libs.o -o o3.node -shared -Wl,-Bdynamic -lxml2
}

do_install () {
 install -m 0755 -d ${D}${datadir}/cloud9 ${D}${bindir} ${D}/var/lib/cloud9
 rsync -r --exclude=".*" ${S}/* ${D}${datadir}/cloud9

 touch ${D}${bindir}/cloud9
 echo "#!/bin/sh" > ${D}${bindir}/cloud9
 echo "node ${datadir}/cloud9/bin/cloud9.js -l 0.0.0.0 -w /var/lib/cloud9 -p 3000" >> ${D}${bindir}/cloud9
 chmod 0755 ${D}${bindir}/cloud9

 install -m 0755 -d ${D}${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/o3-xml
 install -m 0644 ${WORKDIR}/index.js ${D}${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/o3-xml/index.js
 install -m 0644 ${WORKDIR}/o3/modules/o3.js ${D}${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/o3-xml/o3.js
 install -m 0755 ${WORKDIR}/o3/o3.node ${D}${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/o3-xml/o3.node

  install -m 0755 -d ${D}${sysconfdir}/avahi/services/
  install -m 0644 ${WORKDIR}/cloud9-avahi.service ${D}${sysconfdir}/avahi/services/
}

FILES_${PN}-dbg += "${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/o3-xml/.debug \
                    ${datadir}/cloud9/support/jsdav/support/node-o3-xml-v4/lib/.debug \
                   "

RDEPENDS_${PN} = "nodejs gzip"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "cloud9.service"
