package com.code.art.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author zhourao
 * @create 2021-08-20 11:05 上午
 */
public class Code0020 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        backtrack(res, new StringBuffer(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuffer stringBuffer, int open, int close, int n) {
        if (open == close && open == n) {
            res.add(stringBuffer.toString());
        }

        if (open < n) {
            stringBuffer.append("(");
            backtrack(res, stringBuffer, open + 1, close, n);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (close < open) {
            stringBuffer.append(")");
            backtrack(res, stringBuffer, open, close + 1, n);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
    }
}
