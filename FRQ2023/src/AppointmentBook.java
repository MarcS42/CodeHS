


public class AppointmentBook {
    private final boolean[][] appointmentArray2D;
    private int meetingPeriod;
    private int meetingStart;

    public AppointmentBook(int periods, int minutes)
    {
        this.appointmentArray2D = new boolean[periods][minutes];
        this.meetingPeriod = -1;
        this.meetingStart = -1;
    }

    /**
     * Returns true if minute in period is available for an appointment
     * and returns false otherwise.
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59.
     */
    private boolean isMinuteFree(int period, int minute)
    {
        period = period +1;
        return !appointmentArray2D[period - 1][minute];
    }

    /**
     * Marks the block of minutes starting at @startMinute in @period and is
     * @duration minutes long as reserved for an appointment.
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
     * in part 'A'. Returns startMinute in the block if such a block is found,
     * or returns -1 if no such block is found.
     * @param period 1 <= period <= 8.
     * @param duration 1 <= duration <= 60
     *
     */
    public int findFreeMinute(int period, int duration)
    {
        int row = period - 1;
        int col = 0;
        int durationCount = 0;
        while (durationCount != duration &&
                col < (appointmentArray2D[0].length - duration))
        {
            if(isMinuteFree(row, col))
            {
                //if(col !=0 && appointmentArray2D[row][col-1]) setMeetingStart(col);
                durationCount++;
            }
            else
            {
                durationCount = 0;
                //setMeetingStart(-1);
            }
            col++;
        }
        if(col > (appointmentArray2D[0].length - duration)) return -1;
        setMeetingPeriod(period);
        setMeetingStart(col - duration);
        return col - duration;
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

    public void setMeetingStart(int meetingStart)
    {
        this.meetingStart = meetingStart;
    }

    public static void main(String[] args)
    {
        AppointmentBook bk1 = new AppointmentBook(8,60);
        bk1.reserveBlock(0, 2, 10);
        bk1.reserveBlock(15, 2, 15);
        bk1.reserveBlock(45, 2, 5);
        bk1.printBooleanArray(bk1.appointmentArray2D);
        System.out.println("Meeting time minute " + bk1.findFreeMinute(2 , 5) + ". Period " + bk1.meetingPeriod);
    }
}
