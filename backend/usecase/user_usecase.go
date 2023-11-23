package usecase

import (
	_user "backend/domain/user"
)

type userUsecase struct {
	userRepository _user.IUserRepository
}

func NewUserUsecase(ur _user.IUserRepository) _user.IUserUsecase {
	return &userUsecase{userRepository: ur}
}
