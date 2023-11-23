package user

type IUserUsecase interface {
	SelectAll() (*[]User, error)
}
