package com.mokimaki.arput.usecase.user;

import com.mokimaki.arput.domain.model.user.password.RawPassword;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.DomainException;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.user.update.UserUpdateInputData;
import com.mokimaki.arput.presentation.user.update.UserUpdateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase implements IUseCase<UserUpdateInputData, UserUpdateOutputData> {
    private final IUserRepository userRepository;

    public UpdateUserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserUpdateOutputData execute(UserUpdateInputData userUpdateInputData) throws UseCaseException {
        var user = userRepository.findByMailAddress(userUpdateInputData.mailAddress()).orElseThrow(() -> new UseCaseException("ユーザーが見つかりません"));

        try {
            // 情報を更新
            user.setMailAddress(userUpdateInputData.mailAddress());
            user.setName(userUpdateInputData.name());
            user.setSchoolName(userUpdateInputData.schoolName());
            user.setPassword(new RawPassword(userUpdateInputData.password()));
            user.setBio(userUpdateInputData.bio());

            userRepository.update(user);
        } catch (DomainException e) {
            throw new UseCaseException(e.getMessage());
        } catch (Exception e) {
            throw new UseCaseException("ユーザー情報の更新に失敗しました");
        }

        return new UserUpdateOutputData();
    }
}
