package sample.issue.tokens;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.time.Duration;
import java.util.List;

public class CountAndAsk {

    private final String OPENAI_TOKEN = System.getenv("OPENAI_TOKEN");
    private final String OPENAI_MODEL = System.getenv("OPENAI_MODEL");

    public ChatCompletionResult ask(String message) {
        var service  = new OpenAiService(OPENAI_TOKEN, Duration.ofSeconds(30));
        var chatCompletionRequest = ChatCompletionRequest
                .builder()
                .messages(List.of(new ChatMessage(ChatMessageRole.USER.value(), message)))
                .model(OPENAI_MODEL)
//            .maxTokens(4097) // we'll need to come back to it later
                .n(1) // make sure of single result
                .build();
        return service.createChatCompletion(chatCompletionRequest);
    }

}
