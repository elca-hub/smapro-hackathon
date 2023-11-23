package repository

import (
	"backend/domain/model"
)

type IUserRepository interface {
	SelectAll() (*[]model.User, error)
}
