package blog;

import org.junit.jupiter.api.Test;

import static java.time.LocalTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {
    @Test
    void it_should_be_able_to_get_comments() throws CommentAlreadyExistException {
        var article = createArticle();

        String text = "Amazing article !!!";
        String author = "Pablo Escobar";
        article.addComment(text, author);

        assertThat(article.getComments())
                .anyMatch(comment -> commentHasTestAndAuthor(comment, text, author));
    }

    private static Article createArticle() {
        return new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    private static boolean commentHasTestAndAuthor(Comment comment, String text, String author) {
        return comment.text()
                    .equals(text)
                && comment.author()
                    .equals(author);
    }

    @Test
    void it_should_be_able_to_add_a_comment() throws CommentAlreadyExistException {
        var article = createArticle();

        article.addComment("Amazing article !!!", "Carl Max");

        assertThat(article.getComments())
                .hasSize(1);
    }

    @Test
    void it_should_fail_when_adding_an_existing_comment() throws CommentAlreadyExistException {
        var article = createArticle();

        String aComment = "Amazing article !!!";
        String author = "Carl Max";
        article.addComment(aComment, author);

        assertThatThrownBy(() -> {
            article.addComment(aComment, author);
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}
