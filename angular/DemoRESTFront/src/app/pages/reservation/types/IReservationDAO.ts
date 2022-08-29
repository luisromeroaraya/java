export interface IReservationDAO {
  id: number;
  timeArrival: Date;
  timeDeparture: Date;
  canceled: string;
  reason: string;
  childId: number;
  tutorId: number;
}
