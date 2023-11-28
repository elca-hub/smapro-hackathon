package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.user.show.UserShowInputData;
import com.mokimaki.arput.presentation.user.show.UserShowOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class ShowUserUseCase implements IUseCase<UserShowInputData, UserShowOutputData> {
    private final IUserRepository userRepository;

    public ShowUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserShowOutputData execute(UserShowInputData userShowInputData) {
        User user = userRepository.findById(userShowInputData.userId()).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした"));

        return new UserShowOutputData(user);
    }
}
