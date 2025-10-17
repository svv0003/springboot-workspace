package thejoeun.shopping.TheMall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thejoeun.shopping.TheMall.model.Goods;

import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    @Override
    Optional<Goods> findById(Integer id);
}


