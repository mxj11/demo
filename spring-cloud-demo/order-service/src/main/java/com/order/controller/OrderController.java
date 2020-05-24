package com.order.controller;

import com.common.response.ResponseResult;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/v1/place", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult order(@RequestParam("userId") String userId, @RequestParam("productId") String productId) {
        try {
            return orderService.order(userId, productId);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseResult(500, "internal error");
        }
    }
}
