package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Book;

import java.util.List;

public interface BookDao {
    @Insert("insert into tbl_book (type, name, description) values(#{type}, #{name}, #{description})")
    void saveBook(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    void deleteBook(Integer id);

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    void updateBook(Book book);

    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);

    @Select("select * from tbl_book")
    List<Book> getAll();
}
