package yu.upbro.auad.api.v1.utils;

//public class ResponseEntityUtils {
//    public static <T> ResponseEntity<Object> failResponse(CustomException e){
//        return ResponseEntity.status(e.errorEnum.getStatus())
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(ServerResponse.builder()
//                                .state("fail")
//                                .data(e.errorEnum.getErrorCode())
//                                .message(e.errorEnum.getMessage())
//                                .build());
//    }
//
//    public static <T> ResponseEntity<Object> serverResonse(T body){
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(ServerResponse.builder()
//                        .state("success")
//                        .data(body)
//                        .build());
//    }
//}
