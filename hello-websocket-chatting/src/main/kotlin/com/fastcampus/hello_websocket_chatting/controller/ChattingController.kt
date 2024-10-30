package com.fastcampus.hello_websocket_chatting.controller

import com.fastcampus.websocketchatting.controller.ChattingResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

@Controller
class ChattingController { // Chatting Message를 처리한다.

    private val logger = KotlinLogging.logger {}

    @MessageMapping("/chatting-message") // 어디서 처리할지
    @SendTo("/topic/chatting") // 어디로 보낼지 정의
    fun chatting(chattingMessage: ChattingMessage): ChattingResponse { // 메시지 객체 형태로 받고 응답한다.
        logger.info { ">>> Received Message: ${chattingMessage.message}" }
        return ChattingResponse(HtmlUtils.htmlEscape(chattingMessage.message))
    }
}