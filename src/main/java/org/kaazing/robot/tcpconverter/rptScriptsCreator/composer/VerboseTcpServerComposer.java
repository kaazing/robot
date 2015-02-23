/**
 * Copyright (c) 2007-2013, Kaazing Corporation. All rights reserved.
 */

package org.kaazing.robot.tcpconverter.rptScriptsCreator.composer;

import org.kaazing.robot.tcpconverter.packet.Packet;
import org.kaazing.robot.tcpconverter.rptScriptsCreator.emitter.Emitter;
import org.kaazing.robot.tcpconverter.rptScriptsCreator.emitter.EmitterFactory;

public class VerboseTcpServerComposer extends TcpServerComposer {
    private final String NOTE_HEADER = "Scripts in this directory will be formatted contain all the ruperts scripts by server url, then client url, then script type \n";
    private final Emitter noteForScriptFragments = emitterFactory.getNoteEmitter(OUTPUT_TYPE, NOTE_HEADER);

    public VerboseTcpServerComposer(EmitterFactory emitterFactory, Emitter emitter, String ipaddress) {
        super(emitterFactory, emitter, ipaddress);
    }

    protected void processSynAckPacket(Packet packet) {
        super.processSynAckPacket(packet);
        noteForScriptFragments.add(formatFragmentName(packet.getSrcIpAddr(), packet.getSrcPort()) + " accepting form client "
                + packet.getDestIpAddr() + "-" + packet.getDestPort() + "\n");
    }
    
    public void writeToFile(){
        super.writeToFile();
        noteForScriptFragments.commitToFile();
    }
}
