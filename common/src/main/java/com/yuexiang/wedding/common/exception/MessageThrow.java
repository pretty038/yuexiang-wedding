package com.yuexiang.wedding.common.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MessageThrow extends Throwable {

    public MessageThrow(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
