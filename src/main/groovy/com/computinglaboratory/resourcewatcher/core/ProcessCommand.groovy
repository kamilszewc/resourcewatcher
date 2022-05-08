package com.computinglaboratory.resourcewatcher.core

class ProcessCommand {

    def commandResult

    ProcessCommand(command) {
        this.commandResult = command.execute().text
    }

    def by(processor) {
        processor(commandResult)
    }
}
