public class AppointmentBook {
    private final boolean[][] appointmentArray2D;
    private int meetingPeriod;

    private int startMinute;
    public AppointmentBook(int periods, int minutes)
    {
        this.appointmentArray2D = new boolean[periods][minutes];
        this.meetingPeriod = -1;
        this.startMinute = -1;
    }

    /**
     * Returns true if minute in period is available for an appointment
     * and returns false otherwise.
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59.
     */
    private boolean isMinuteFree(int row, int minute)
    {
        return !appointmentArray2D[row][minute];
    }

    /**
     * Marks the block of minutes starting at
     * @param startMinute in
     * @param period and is
     * @param duration minutes long as reserved for an appointment.
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59; 1 <= duration <= 60
     */
    private void reserveBlock(int startMinute, int period, int duration)
    {
        int row = period-1;
        for (int col = startMinute; col < (startMinute + duration); col++ )
        {
            appointmentArray2D[row][col] = true;
        }
    }

    /**
     * Searches first block of duration free minutes in period as described
     * in part 'a'. Returns startMinute in the block if such a block is found,
     * or returns -1 if no such block is found.
     * @param period 1 <= period <= 8.
     * @param duration 1 <= duration <= 60
     *
     */
    public int findFreeMinute(int period, int duration)
    {
        int row = period - 1;
        int col;
        int durationCount = 0;
        for (col = 0;col < appointmentArray2D[0].length; col++)
        {
            //if (col > (appointmentArray2D[0].length-1 - duration) &&
            // durationCount == 0) return -1;
            if(isMinuteFree(row, col)) durationCount++;
                else durationCount = 0;
            if (durationCount == duration)
            {
                setMeetingPeriod(period);
                return col - duration + 1;// Col is zero based while Duration
                // starts at 1 so if Duration is 10, col end minute would be
                // 9, and 9 -10 = -1 not the desired 0.
            }
        }
        return -1;
    }

    /**
     * Searches periods from
     * <code>startPeriod</code> to
     * <code>endPeriod</code>, inclusive, for a block of
     * <code>duration</code> free minutes. If such a block is found, calls
     * <code>reserveBlock(int period, int startMinute)</code> to reserve the
     * block of minutes and returns <code>true</code>; otherwise returns
     * <code>false</code>.
     * */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration)
    {
        boolean returnMe = false;
        for (int i = startPeriod; i <= endPeriod; i++)
        {
            int startMinute = findFreeMinute(i, duration);
            if(startMinute > -1)
            {
                reserveBlock(startMinute, i, duration);
                setStartMinute(startMinute);
                return true;
            }
        }
        setMeetingPeriod(-1);
        setStartMinute(-1);
        return returnMe;
    }

    public void printBooleanArray(boolean[][] appointmentArray2D)
    {
        System.out.print("  ");
        for(int colCount= 0; colCount < appointmentArray2D[0].length; colCount++)
        {
            System.out.print( colCount + " ");
        }
        int period = 0;
        for (boolean[] booleans : appointmentArray2D)
        {

            System.out.println();
            for (int col = 0; col < appointmentArray2D[0].length; col++)
            {
                if(col == 0)
                {
                    System.out.print(period + 1 + " ");
                    period++;
                }
                if(col < 10)
                {
                    if (booleans[col]) {
                        System.out.print("T ");
                    } else {
                        System.out.print("F ");
                    }
                }else {
                    if (booleans[col]) {
                        System.out.print(" T ");
                    } else {
                        System.out.print(" F ");
                    }
                }

            }

        }
        System.out.println();
    }

    public void setMeetingPeriod(int meetingPeriod)
    {
        this.meetingPeriod = meetingPeriod;
    }

    public void setStartMinute(int startMinute)
    {
        this.startMinute = startMinute;
    }

    public static void main(String[] args)
    {
        AppointmentBook bk1 = new AppointmentBook(8,60);
        bk1.reserveBlock(0, 2, 25);
        bk1.reserveBlock(30, 2, 30);
        bk1.reserveBlock(15, 3, 26);
        bk1.reserveBlock(0, 4, 5);
        bk1.reserveBlock(30, 4, 14);
        bk1.printBooleanArray(bk1.appointmentArray2D);
        System.out.println("Appointment Available?: " + bk1.makeAppointment(2, 4
                , 22) + ". Period " + bk1.meetingPeriod +" Start Minute: " + bk1.startMinute);
        System.out.println("Appointment Available?: " + bk1.makeAppointment( 3, 4, 3) + ". Period " + bk1.meetingPeriod + " Start Minute: " + bk1.startMinute);
        System.out.println("Appointment Available?: " + bk1.makeAppointment( 4, 4, 16) + ". Period " + bk1.meetingPeriod + " Start Minute: " + bk1.startMinute);
        bk1.printBooleanArray(bk1.appointmentArray2D);
    }
}



