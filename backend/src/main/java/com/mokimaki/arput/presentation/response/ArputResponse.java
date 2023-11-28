package com.mokimaki.arput.presentation.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public abstract class ArputResponse {
    @NonNull
    public ResponseStatus status;
    public String message = null;
}
