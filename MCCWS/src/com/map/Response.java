package com.map;

/**
 * Response of json
 * @author josephpr
 *
 */
public class Response {
    String[] debug_info;
    String[] html_attributions;
    Result[] results;
    
    public Response(){
        
    }

    public String[] getDebug_info() {
        return debug_info;
    }

    public void setDebug_info(String[] debug_info) {
        this.debug_info = debug_info;
    }

    public String[] getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(String[] html_attributions) {
        this.html_attributions = html_attributions;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }
    
    
}
