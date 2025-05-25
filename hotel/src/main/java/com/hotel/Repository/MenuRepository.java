package com.hotel.Repository;

import com.hotel.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {


    public List<Menu> findByMenuNameContainingIgnoreCase(String menuName);
}
