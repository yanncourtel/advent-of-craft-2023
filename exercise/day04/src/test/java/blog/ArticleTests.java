package blog;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {

    public static final String AN_AUTHOR = "Pablo Escobar";

    @Test
    void it_should_add_valid_comment() throws CommentAlreadyExistException {
        var article = createComment();

        article.addComment("Amazing article !!!", AN_AUTHOR);
    }

    @Test
    void it_should_add_a_comment_with_the_given_text() throws CommentAlreadyExistException {
        var article = createComment();

        var text = "Amazing article !!!";
        article.addComment(text, AN_AUTHOR);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.text().equals(text));
    }

    private static Article createComment() {
        return new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }

    @Test
    void it_should_add_a_comment_with_the_given_author() throws CommentAlreadyExistException {
        var article = createComment();

        article.addComment("Amazing article !!!", AN_AUTHOR);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.author().equals(AN_AUTHOR));
    }

    @Test
    void it_should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        var article = createComment();

        article.addComment("Amazing article !!!", AN_AUTHOR);
    }

    @Test
    void it_should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {
        var article = createComment();
        article.addComment("Amazing article !!!", AN_AUTHOR);

        assertThatThrownBy(() -> {
            article.addComment("Amazing article !!!", AN_AUTHOR);
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}
