import axios from 'axios';
import { TaskBookingContext } from './task-booking.model';

const baseApiUrl = 'api/midia-go-process/task-booking';

export default class TaskBookingService {
  public loadContext(taskId: number): Promise<TaskBookingContext> {
    return new Promise<TaskBookingContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskBookingContext> {
    return new Promise<TaskBookingContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskBookingContext: TaskBookingContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskBookingContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
