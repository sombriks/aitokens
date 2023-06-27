package sample.issue.tokens;

import com.didalgo.gpt3.Encoding;
import com.didalgo.gpt3.GPT3Tokenizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountAndAskTest {

    private final String OPENAI_MODEL = System.getenv("OPENAI_MODEL");
    private CountAndAsk service = new CountAndAsk();

    @Test
    public void shouldReturnSameTokenCount() {

        String hello = "Hello there!";

        GPT3Tokenizer tokenizer = new GPT3Tokenizer(Encoding.forModel(OPENAI_MODEL));
        var tokens = tokenizer.encode(hello);

        var result = service.ask(hello);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(tokens.size(), result.getUsage().getPromptTokens());
    }
}
