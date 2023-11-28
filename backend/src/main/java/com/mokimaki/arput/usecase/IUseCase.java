package com.mokimaki.arput.usecase;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;

public interface IUseCase<I, O> {
    O execute(I input) throws UseCaseException;
}
