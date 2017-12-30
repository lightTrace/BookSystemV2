package cn.com.controller;

import cn.com.activimq.producer.ProducerServiceImpl;
import cn.com.entity.Book;
import cn.com.service.BookService;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * ${DESCRIPTION}
 *
 * @author lightTrace
 * @create 2017-10-26 21:57
 **/
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;
    @Resource
    private ProducerServiceImpl producerServiceImpl;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> list = bookService.getList(0, 1000);
        model.addAttribute("list", list);
        return "list";// WEB-INF/jsp/"list".jsp
    }
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    private String addPage(Model model) {
        return "add";// WEB-INF/jsp/"list".jsp
    }
    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.getById(bookId);
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    private String add(Book book,Model model) {
          Book hasBook = bookService.getById(book.getBookId());
          String bookJsonString = JSON.toJSONString(book);
          producerServiceImpl.sendMessage(bookJsonString);
          return "list";
    }

    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    private String deleteBookById(@PathVariable("bookId") Long id) {
        int i = bookService.deleteBookById(id);
        return i > 0 ? "success" : "error";
    }
}
