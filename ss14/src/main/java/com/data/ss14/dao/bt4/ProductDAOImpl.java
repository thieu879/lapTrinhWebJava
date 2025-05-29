package com.data.ss14.dao.bt4;
import com.data.ss14.model.bt4.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void saveProduct(Product p) {
        // Không thao tác với DB thật, chỉ demo cookie
    }

    @Override
    public List<Product> getProductsFromCookies(String cookieValue) {
        List<Product> list = new ArrayList<>();
        if (cookieValue != null) {
            String[] items = cookieValue.split(",");
            for (String item : items) {
                String[] data = item.split(":");
                if (data.length == 2) {
                    list.add(new Product(data[0], Integer.parseInt(data[1])));
                }
            }
        }
        return list;
    }
}

