package com.example.demo.repository;
import com.example.demo.model.Post;
import com.example.demo.model.Poststate;
import com.example.demo.model.icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface postRepository extends JpaRepository<Post, Long> {


    List<Post> findByCompanyid(String company_id);
    List<Post> findByPoststateOrderByPostedateDesc( Poststate poststate);

    List<Post> findByPoststateAndTypeOrderByPostedateDesc( Poststate poststate, String type);
    List<Post> findByPoststateAndCityOrderByPostedateDesc( Poststate poststate, String city);
    List<Post> findByPoststateAndTypeAndCityOrderByPostedateDesc( Poststate poststate,String type ,String city);
    List<Post> findByIdIn(List<Long> IdsList);
    @Query(value = "SELECT * FROM post WHERE postedate Like %?1%", nativeQuery = true)
    List<Post> findByMatchMonthAndYear(@Param("eventDate") String eventDate);
}
