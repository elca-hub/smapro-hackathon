package user

type IUserRepository interface {
	SelectAll() (*[]User, error)
}
