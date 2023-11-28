package com.mokimaki.arput.presentation.response;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public abstract class ArputResponse<O> {
    @NonNull
    public ResponseStatus status;
    public String message = null;

    public abstract ArputResponse<O> success(O outputData);
    public abstract ArputResponse<O> error(UseCaseException e);
}
