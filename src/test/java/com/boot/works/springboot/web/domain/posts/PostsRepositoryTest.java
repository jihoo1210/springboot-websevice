package com.boot.works.springboot.web.domain.posts;

import com.boot.works.springboot.domain.posts.PostsRepository;
import com.boot.works.springboot.domain.posts.Posts;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    //Junit에서 단위 테스트가 끝날 때마다 수행할 메소드
    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void postSaveAndLoad() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 테이블 posts에 insert/update 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("test@example.com")
                .build());

        //when
        // posts에 있는 모든 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntityResister() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> createDate= " + posts.getCreatedAt() + ", modifiedDate= " +posts.getModifiedDate());
        assertThat(posts.getCreatedAt()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
