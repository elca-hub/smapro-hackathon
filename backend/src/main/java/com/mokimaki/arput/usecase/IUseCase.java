package com.mokimaki.arput.usecase;

public interface IUseCase<I, O> {
    O execute(I input);
}
