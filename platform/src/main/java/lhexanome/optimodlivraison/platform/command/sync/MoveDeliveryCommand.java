package lhexanome.optimodlivraison.platform.command.sync;

import lhexanome.optimodlivraison.platform.compute.InterfaceCalcul;
import lhexanome.optimodlivraison.platform.compute.SimplifiedMap;
import lhexanome.optimodlivraison.platform.models.Delivery;
import lhexanome.optimodlivraison.platform.models.Halt;
import lhexanome.optimodlivraison.platform.models.Path;
import lhexanome.optimodlivraison.platform.models.RoadMap;
import lhexanome.optimodlivraison.platform.models.Tour;

import java.util.logging.Logger;

/**
 * Change time slot of a delivery.
 */
public class MoveDeliveryCommand extends UndoableCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MoveDeliveryCommand.class.getName());

    /**
     * Tour.
     */
    private final Tour tour;

    /**
     * Delivery to move.
     */
    private final Delivery selectedValue;

    /**
     * New index.
     */
    private final int newIndex;
    /**
     * Compute interface.
     */
    private InterfaceCalcul interfaceCalcul;
    /**
     * RoadMap
     */

    private RoadMap roadMap;
    /**
     * SimplifiedMap
     */

    private SimplifiedMap simplifiedMap;
    /**
     *  removed path
     */
    private Path removedPath;

    private Path previewRemovedPath;

    private Path afterRemovedPath;

    private int compteur=0;


    /**
     * Constructor.
     *
     * @param tour          Tour
     * @param selectedValue Delivery to edit
     * @param newIndex      New index
     */
    public MoveDeliveryCommand(Tour tour, Delivery selectedValue, int newIndex) {
        this.tour = tour;
        this.selectedValue = selectedValue;
        this.newIndex = newIndex;
        SimplifiedMap simplifiedMap;
    }

    /**
     * Executed by the execute method.
     */
    @Override
    protected void doExecute() {


        for (Path p:tour.getPaths()) {
            if(p.getEnd()==selectedValue){
                break;
            }
            compteur++;
        }
        tour.getPaths().add(compteur, simplifiedMap.shortestPathList(tour.getPaths().get(compteur).getStart(), tour.getPaths().get(compteur+1).getEnd()));
        previewRemovedPath = tour.getPaths().remove(compteur+1);
        afterRemovedPath = tour.getPaths().remove(compteur+1);

        Halt previousHalt = tour.getPaths().get(newIndex).getStart();
        Halt afterHalt = tour.getPaths().get(newIndex).getEnd();
        removedPath = tour.getPaths().remove(newIndex);
        tour.getPaths().add(newIndex,simplifiedMap.shortestPathList(previousHalt, selectedValue));
        tour.getPaths().add(newIndex+1,simplifiedMap.shortestPathList(selectedValue, afterHalt));
        //TODO tour.notifyObservers() à rajouter.

    }

    /**
     * Executed by the undo method.
     */
    @Override
    protected void doUndo() {
        tour.getPaths().remove(newIndex);
        tour.getPaths().remove(newIndex);
        tour.getPaths().add(newIndex, removedPath);
        tour.getPaths().remove(compteur);
        tour.getPaths().add(compteur, previewRemovedPath);
        tour.getPaths().add(compteur+1,afterRemovedPath);
    }

    /**
     * Executed by the redo method.
     */
    @Override
    protected void doRedo() {

        doExecute();

    }
}
