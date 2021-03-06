package com.youngsuk.justbook.book;

import com.youngsuk.justbook.domain.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/books/category")
public class BookController {

  private BookService bookService;

  @Autowired
  public void setBookService(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public List<String> getAllCategoryName() {
    return bookService.getAllCategoryName();
  }

  @GetMapping("rating")
  public BookPagingDto getBookSortByRating(@RequestParam Integer page) {
    // 평점 순서대로 책 데이터를 가져올때 페이징을 통해 데이터를 전달하기 위해 page를 넘겨주었다.
    return bookService.getBookSortByRating(page);
  }

  @GetMapping("{id}")
  public List<Book> getBookByCategory(@PathVariable String id, Pageable pageable) {
    return bookService.getBookByCategory(id, pageable);
  }

  @GetMapping("search")
  public List<Book> search(@RequestParam String keyword, Pageable pageable) {
    return bookService.search(keyword, pageable);
  }
}
