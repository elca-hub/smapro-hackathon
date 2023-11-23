package repository

import (
	"backend/domain/model"
	"context"
)

type IUserRepository interface {
	SelectAll(ctx context.Context) (*[]model.User, error)
}
