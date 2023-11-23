package mysql

import (
	_user "backend/domain/user"

	"gorm.io/gorm"
)

type userRepository struct {
	DB *gorm.DB
}

func NewUserRepository(db *gorm.DB) _user.IUserRepository {
	return &userRepository{DB: db}
}

func (ur *userRepository) SelectAll() (*[]_user.User, error) {
	var users []_user.User
	if err := ur.DB.Find(&users).Error; err != nil {
		return nil, err
	}
	return &users, nil
}
