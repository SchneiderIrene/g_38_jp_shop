package de.ait_tr.g_38_jp_shop.exception_handling;

import java.util.Objects;

public class Response {

    private String message;
    private String additionalMessage;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, String additionalMessage) {
        this.message = message;
        this.additionalMessage = additionalMessage;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(message, response.message) && Objects.equals(additionalMessage, response.additionalMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, additionalMessage);
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", additionalMessage='" + additionalMessage + '\'' +
                '}';
    }
//    private Object body;
//
//    public Response(String message) {
//        this.message = message;
//    }
//
//    public Response(Object body) {
//        this.body = body;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public Object getBody() {
//        return body;
//    }
//
//    public boolean containsError() {
//        return message != null;
//    }
//
//    public void test() {
//        Response response = new Response(new ProductDto());
//
//        if (response.containsError()) {
//            //
//        } else {
//
//        }
//    }
}
