/**
 * Copyright (c) 2007-2013, Kaazing Corporation. All rights reserved.
 */

package org.kaazing.robot.tcpconverter.rptScriptsCreator.script;

/**
 * Tcp State that a Rpt Script can be in
 *
 */
public enum ScriptState {
    NOT_INITED, ACCEPT, CONNECT, CONNECTED, CLOSE_READ, CLOSE_WRITE, CLOSED 
}
