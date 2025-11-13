package com.spring.stockflow.util;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Pagination {

    private int pageNum = 1;
    private int amount = 2;

    private String[] types;
    private String typeStr;
    private String keyword;

    //날짜 검색
    private String startDate;
    private String endDate;

    public void setPageNum(int pageNum) {
        if (pageNum <= 0) {
            this.pageNum = 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public void setAmount(int amount) {
        if (amount <= 10 || amount > 100) {
            this.amount = 10;
            return;
        }
        this.amount = amount;
    }

    public void setTypes(String[] types) {
        this.types = types;

        if (types != null && types.length > 0) {
            typeStr = String.join("", types);
        }
    }

    public int getSkip() {
        return (this.pageNum - 1) * this.amount;
    }
}
