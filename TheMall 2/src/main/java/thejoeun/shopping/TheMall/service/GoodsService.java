package thejoeun.shopping.TheMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thejoeun.shopping.TheMall.model.Goods;
import thejoeun.shopping.TheMall.repository.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    // JPARepository에 내장되어 있는 findAll 메서드를 활용하여 Goods Entity로 커스텀해서 사용한다.
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }
}
