package uz.micros.estore.controller.viewmodels;

import java.util.*;

public class ExecParams {
    private String query;
    private List<Map<String, Object>> result;
    private String err;

    public ExecParams() {
        result = new ArrayList<Map<String, Object>>();
        result.add(new HashMap<String, Object>());
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Map<String, Object>> getResult() {

        return result;
    }

    public void setResult(List<Map<String, Object>> result) {
        this.result = result;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}
