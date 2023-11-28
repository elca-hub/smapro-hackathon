package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.domain.service.user.UserService;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.user.delete.UserDeleteInputData;
import com.mokimaki.arput.presentation.dto.user.delete.UserDeleteOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCase implements IUseCase<UserDeleteInputData, UserDeleteOutputData> {
    private final IUserRepository userRepository;
    private final UserService userService;

    public DeleteUserUseCase(IUserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public UserDeleteOutputData execute(UserDeleteInputData inputData) throws UseCaseException {
        if (!userService.isExist(new UserId(inputData.getUserId()))) {
            throw new UseCaseException("ユーザーが見つかりませんでした");
        }

        try {
            userRepository.delete(inputData.getUserId());
            return new UserDeleteOutputData();
        } catch (Exception e) {
            throw new UseCaseException("ユーザーの削除に失敗しました");
        }
    }
}
