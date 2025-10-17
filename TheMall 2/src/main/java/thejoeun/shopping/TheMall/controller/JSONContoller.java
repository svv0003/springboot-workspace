package thejoeun.shopping.TheMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thejoeun.shopping.TheMall.model.Goods;
import thejoeun.shopping.TheMall.service.GoodsService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class JSONContoller {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/api/goods")
    public List<Goods> findAll() {
        return goodsService.findAll();
    }
}
